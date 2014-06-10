#http://books.sonatype.com/mvnex-book/reference/web-sect-creating-project.html

mvn archetype:generate -DgroupId=com.faktor73.sample \
      -DartifactId=sample-webapp-jetty \
	        -Dpackage=come.faktor73.sample.webapp \
			      -Dversion=1.0-SNAPSHOT \
				  -DarchetypeArtifactId=maven-archetype-webapp

mvn eclipse:eclipse -Dwtpversion=2.0
