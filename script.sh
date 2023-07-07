mkdir ./WEB-INF
cd ./WEB-INF
mkdir ./classes
mkdir ./lib

cd ../
cp ./Framework/sprint.jar ./WEB-INF/lib
cp ./Framework/dom-2.3.0-jaxb-1.0.6.jar ./WEB-INF/lib
cp ./Framework/gson-2.8.2.jar ./WEB-INF/lib
cp ./Framework/servlet-api.jar ./WEB-INF/lib
cp -R ./Test/test ./WEB-INF/classes
cp ./Test/views/*.jsp ./ 
cp ./web.xml ./WEB-INF

jar cvf Sprint.war ./*.jsp ./WEB-INF
mv Sprint.war ../ 

rm -R ./WEB-INF
rm ./*.jsp