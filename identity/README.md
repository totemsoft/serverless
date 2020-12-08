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
