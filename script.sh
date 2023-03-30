javac -d ./ Mapping.java
javac -d ./ Anno_test.java
javac -d ./ Util.java
javac -d ./ FrontServlet.java

jar cvf sprint.jar annotations etu1812 utils
mv ./sprint.jar ../lib

javac -d ./ -cp ../lib/sprint.jar Test.java

cd ../../

jar cvf test_sprint.war WEB-INF

mv test_sprint.war ../