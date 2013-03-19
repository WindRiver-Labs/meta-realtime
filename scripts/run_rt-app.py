#
# run rt-app on remote machine and collect the data
#
# note:
#
# 0. install fabric 1.6 on the develop host
# - $ pip install fabric
#
# 1. copy ssh public key (copy and paste host's "~/.ssh/id_rsa.pub" to the remote's ~/.ssh/authorized_keys)
#
# 2. update the "env.hosts" with your remote system
#
# 3. run the script from the host
# - $ fab -f run_rt-app.py run_app
#

from __future__ import with_statement
from fabric.api import *
from fabric.contrib import *
from fabric.contrib.console import confirm

import socket
import getpass
import datetime
import time
import datetime


env.hosts = ['root@192.168.1.78']
remote_ip = env.hosts[0]

now = datetime.datetime.now()

YES	= "/usr/bin/yes"
KILLALL	= "/usr/bin/killall"
SCP	= "/usr/bin/scp"

RTAPP	= "/usr/bin/rt-app"

period_t	= 100000
run_t		= 30000

num_run = 10
sec_run = 100

dir_name	= "/home/root"
f_name		= "rt-app_run_log-%s.txt" % now.strftime("%Y-%m-%d-%H-%M")
file_name	= "%s/%s" % (dir_name, f_name)
	
def pre():
	print "\n==========================================================="
	print "1. Conecting remote : %s" % env.hosts[0]
	print "===========================================================\n"

	# scripts that runs on the remote
	un = run("uname -a", quiet=True)
	hn = run("hostname", quiet=True)
	print "running script on host [%s], OS[%s]" % (hn, un)

#
# run the app on the remote and collect the data into log
#
def main():
	print "\n==========================================================="
	print "2. Running rt-app %s times.." % num_run
	print "===========================================================\n"

	run('echo \"test log (period = %s, execution time %s) run %s times on each %s sec \n\n\" > %s' % \
		(period_t, run_t, num_run, sec_run, file_name))
	for i in range(0, num_run):
		run("%s -t %s:%s:d -D %s >> %s" %  \
			(RTAPP, period_t, run_t, sec_run, file_name))

#
# bring the data log to the host
#
def post():
	# running this from local host
	local("%s %s:%s ." % (SCP, remote_ip, file_name))

	print "\n=============================================================================="
	print "3. Run finished, and log file ""%s"" is copied to host." % f_name
	print "==============================================================================\n"

def run_app():
	pre()
	main()
	post()
