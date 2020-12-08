package au.com.totemsoft.ping.http;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.security.auth.x500.X500PrivateCredential;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pingidentity.access.KeyAccessor;

import lombok.Generated;

@Generated
public class CloseableHttpClientBuilder {

    private static final Logger LOG = LogManager.getLogger(CloseableHttpClientBuilder.class);

    private String keyStoreAlias;
    private char[] keyStorePassword;
    private String[] protocols;
    private X509HostnameVerifier hostnameVerifier;

    private CloseableHttpClientBuilder(boolean strictHostName) { 
        this.protocols = new String[] { "TLSv1.2" };
        //this.hostnameVerifier = new DefaultHostnameVerifier();
        this.hostnameVerifier = strictHostName ? SSLConnectionSocketFactory.STRICT_HOSTNAME_VERIFIER : SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
    }

    public static CloseableHttpClient getInstance(String keyStoreAlias) throws IOException {
        return new CloseableHttpClientBuilder(false)
            .useMutualTls(keyStoreAlias)
            .build();
    }

    private CloseableHttpClientBuilder useMutualTls(String keyStoreAlias) {
        this.keyStoreAlias = keyStoreAlias;
        this.keyStorePassword = RandomStringUtils.randomAlphabetic(16).toCharArray(); 
        return this;
    }

    private CloseableHttpClient build() throws IOException {
        try {
            KeyStore keyStore = getKeyStore(keyStoreAlias, this.keyStorePassword);
            SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
            SSLContext sslContext = sslContextBuilder.loadKeyMaterial(keyStore, this.keyStorePassword).build();
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, protocols, null, hostnameVerifier);
            // Create the HttpClient.
            return HttpClientBuilder.create().setSSLSocketFactory(socketFactory).build();
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private KeyStore getKeyStore(String pfKeyStoreAlias, char[] keyStorePassword) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        LOG.info("Getting KeyStore from PingFederate");
        // first, retreive the cert from PingFederates Keystore.
        KeyAccessor keyAcc = new KeyAccessor();
        X500PrivateCredential sslclientkeypair = keyAcc.getClientSslKeypair(pfKeyStoreAlias);

        // Now create a new Keystore to store the client cert in
        //KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null);

        // Use a static keyStoreAlias in the keystore, the password is passed into the
        // method this doesn't really matter as we store it in memory, and never write
        // it to a file.
        String keyStoreAlias = "clientCertificate";
        //char[] keyStorePassword = RandomStringUtils.randomAlphabetic(16).toCharArray();

        // Now store the client certificate we retrieved from Ping Federate and
        // store it in the keystore we just created.
        keyStore.setKeyEntry(keyStoreAlias, 
            sslclientkeypair.getPrivateKey(),
            keyStorePassword,
            new X509Certificate[] { sslclientkeypair.getCertificate() });

        LOG.info("KeyStore found");
        return keyStore;
    }

}
