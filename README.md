# urlshort


설치 및 배포
 
   외장 톰캣 배포시
   
    1. Tomcat webapps 폴더에 해당 war파일 업로드
    2. server.xml(conf폴더안에 위치함)에 war배포 태그 입력 
       <Context path="" docBase="/usr/local/lib/apache-tomcat-8.5.57/webapps/war파일명" reloadable="true" />
    3. bin 폴더에서 재기동  (./shutdown.sh  -> ./startup.sh)

   내장 톰캣 배포시
   
    1. gradle를 이용하여 jar 패키징
    2. jdk 설치
    3. 서버에 해당 jar 파일 업로드
    4. jar 실행
      java -jar 해당파일명.jar
    
  



