#!/bin/sh

#!/bin/bash
PROJECT_PATH=`pwd`
cd $PROJECT_PATH/lib
jarFile=''
for filename in *;
do
	jarFile=$jarFile$PROJECT_PATH'/lib/'$filename':'
done
cd ..

while :
	do
	java -Xms1024m -Xmx1024m -Xss1024k -XX:PermSize=256M -XX:MaxPermSize=512M -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=60 -verbose:gc -Xloggc:/var/javalogs/gc.log -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -cp $jarFile:$PROJECT_PATH/calc-0.0.1-SNAPSHOT.jar:. cn.com.gome.rebate.job.calc.Calc
	# 每次监测时间60秒
	sleep 10
done
