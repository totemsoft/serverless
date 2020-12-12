# Maven CI Friendly

    http://maven.apache.org/maven-ci-friendly.html

If you like to make a version 1.0.0-SNAPSHOT this can simply being achieved by using this:

    mvn -Drevision=1.0.0 clean package

Another usage example can be to make a release which can be done via (version 1.0.0):

    mvn -Dchangelist= clean package

Or if you like to make a release with another version:

    revision=1.0.0
    changelist=
    MAVEN_ARGS_APPEND=-Drevision=$(revision) -Dchangelist=$(changelist) -rf $(ApplicationName)

    mvn -Drevision=1.0.0 -Dchangelist=-SNAPSHOT clean install
    mvn -Drevision=1.0.0 -Dchangelist= clean install

    PF_LIB=./lib
    PF_VERSION=10.2.0
    PF_SDK_VERSION=1.0.0.54
    mvn install:install-file -Dfile=$PF_LIB/pf-authn-api-sdk-$PF_SDK_VERSION.jar -DgroupId=pingfederate -DartifactId=pf-authn-api-sdk -Dversion=$PF_SDK_VERSION -Dpackaging=jar
    mvn install:install-file -Dfile=$PF_LIB/pf-protocolengine.jar -DgroupId=pingfederate -DartifactId=pf-protocolengine -Dversion=$PF_VERSION -Dpackaging=jar
    mvn install:install-file -Dfile=$PF_LIB/pf-core-plugins.jar -DgroupId=products.plugins -DartifactId=pf-core-plugins -Dversion=$PF_VERSION -Dpackaging=jar
    mvn install:install-file -Dfile=$PF_LIB/pf-commons.jar -DgroupId=pingfederate -DartifactId=pf-commons -Dversion=$PF_VERSION -Dpackaging=jar
    mvn install:install-file -Dfile=$PF_LIB/ping-common-api.jar -DgroupId=com.pingidentity.commonsvcs -DartifactId=ping-common-api -Dversion=$PF_VERSION -Dpackaging=jar
    mvn install:install-file -Dfile=$PF_LIB/ping-common-mgmt.jar -DgroupId=com.pingidentity.commonsvcs -DartifactId=ping-common-mgmt -Dversion=$PF_VERSION -Dpackaging=jar
