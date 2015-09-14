/*
 * main.cpp
 *
 *  Created on: Sep 14, 2015
 *      Author: ricardovhz
 */
#include <unistd.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <syslog.h>

int main() {
	pid_t pid, sid;

	pid = fork();
	if (pid < 0) {
		exit(EXIT_FAILURE);
	} else if (pid > 0) {
		exit(EXIT_SUCCESS);
	}

	umask(0);

	openlog("MEERKWATCH", LOG_NDELAY | LOG_PID, LOG_DAEMON);

	sid = setsid();
	if (sid < 0) {
		syslog(LOG_EMERG, "Nao foi possivel configurar o sid no aplicativo");
		closelog();
		exit(EXIT_FAILURE);
	}

	if ((chdir("/")) < 0) {
		syslog(LOG_EMERG, "Não foi possivel trocar para o diretório padrão");
		closelog();
		exit(EXIT_FAILURE);
	}

	close(STDIN_FILENO);
	close(STDOUT_FILENO);
	close(STDERR_FILENO);

	syslog(LOG_INFO, "Iniciando processo de dormir");

	int i=0;

	for (;;) {
		i++;
		if (i > 10) {
			syslog(LOG_INFO, "Fechando daemon...");
			closelog();
			exit(EXIT_SUCCESS);
		}
		sleep(5);
	}

}

