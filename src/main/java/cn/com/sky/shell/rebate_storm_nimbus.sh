#!/bin/sh


STORM_PATH=/usr/local/storm-0.9.4/bin/
STORM_RESTART_LOG=/usr/local/storm-0.9.4/bin/storm_restart.log

pid=`ps -ef|grep "backtype.storm.daemon.nimbus"|grep -v grep|awk '{print $2}'`

DATE=$(date '+%Y-%m-%d %H:%M:%S')

pid(){
	ps -ef|grep "backtype.storm.daemon.nimbus"
}

start(){
	echo $DATE "starting the storm nimbus..." >> $STORM_RESTART_LOG 2>&1 
	cd $STORM_PATH
	./storm nimbus &
	echo $DATE "the storm nimbus start ok..." >>  $STORM_RESTART_LOG 2>&1
}

stop(){
	echo $DATE "shutting down the storm nimbus..."${pid} >>  $STORM_RESTART_LOG 2>&1
	kill -9 ${pid} 
	echo $DATE "the storm nimbus stop ok..." >>  $STORM_RESTART_LOG 2>&1
}


monitor(){
	while :
	do
		pid=`ps -ef|grep "backtype.storm.daemon.nimbus"|grep -v grep|awk '{print $2}'`
		if [ -n "$pid" ]
			then  echo $DATE "nimbus is running..." >>  $STORM_RESTART_LOG 2>&1
		else
			DATE=$(date '+%Y-%m-%d %H:%M:%S')
			echo $DATE "nimbus is died..."   >>  $STORM_RESTART_LOG 2>&1
                        start
		fi
	# 每次监测时间60秒
	sleep 10
done
}



case "$1" in
	pid)
pid
;;
start)
start
;;
stop)
stop
;;
restart)
stop
sleep 10
start
;;
log) 
log
;;
monitor)
monitor
;;

*)
echo "Usage: $0 {monitor|start|stop|restart|pid}"
esac
exit 0


