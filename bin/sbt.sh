#!/bin/sh
test -f ~/.sbtconfig && . ~/.sbtconfig
exec java -Xmx512M ${SBT_OPTS} -jar `dirname $0`/sbt-launch-0.10.0.jar "$@"
