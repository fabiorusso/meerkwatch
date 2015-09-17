/*
 * IPCCommunicator.h
 *
 *  Created on: Sep 17, 2015
 *      Author: frusso
 */

#ifndef MONITORAMENTO_CORE_IPCCOMMUNICATOR_H_
#define MONITORAMENTO_CORE_IPCCOMMUNICATOR_H_

class IPCCommunicator {
public:
	IPCCommunicator();
	virtual ~IPCCommunicator();
	void send(IPCMessage message);
	void onReceive();
};

#endif /* MONITORAMENTO_CORE_IPCCOMMUNICATOR_H_ */
