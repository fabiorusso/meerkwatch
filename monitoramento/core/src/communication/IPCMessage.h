/*
 * IPCMessage.h
 *
 *  Created on: Sep 17, 2015
 *      Author: frusso
 */

#ifndef MONITORAMENTO_CORE_IPCMESSAGE_H_
#define MONITORAMENTO_CORE_IPCMESSAGE_H_

#include <stddef.h>
#include <stdlib.h>
#include <cstring>

using namespace std;

class IPCMessage {
private:
	void *data;
public:
	IPCMessage(const void* data, size_t size) {
		this->data = malloc(size+1);
		this->data = memcpy(this->data, data, size);
	}
	;
	virtual ~IPCMessage() {
		free(data);
	}
	;

	void *getData();

};

#endif /* MONITORAMENTO_CORE_IPCMESSAGE_H_ */
