# urlshort


1. Java 설치하기

 - wget http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.tar.gz
   Java 압축해제 & 파일 이동
 - tar -xvzf jdk-8u131-linux-x64.tar.gz
 - mkdir /usr/java
 - mv jdk1.8.0_131/* /usr/java/jdk1.8.0_131


2. 배포
  1) 외장 톰캣 배포시
    - Tomcat webapps 폴더에 해당 war파일 업로드
    - server.xml(conf폴더안에 위치함)에 war배포 태그 입력 
     <Context path="" docBase="/usr/local/lib/apache-tomcat-8.5.57/webapps/war파일명" reloadable="true" />
    - bin 폴더에서 재기동  (./shutdown.sh  -> ./startup.sh)

  2) 내장 톰캣 배포시
    - gradle를 이용하여 jar 패키징
    - jdk 설치
    - 서버에 해당 jar 파일 업로드
    - jar 실행
      java -jar 해당파일명.jar
    
  



