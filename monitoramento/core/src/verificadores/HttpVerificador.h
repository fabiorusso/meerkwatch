/*
 * HttpVerificador.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef VERIFICADORES_HTTPVERIFICADOR_H_
#define VERIFICADORES_HTTPVERIFICADOR_H_

#include "DisponibilidadeVerificador.h"

namespace meerkwatch {

class HttpVerificador: public DisponibilidadeVerificador {
public:
	HttpVerificador();
	virtual ~HttpVerificador();
};

} /* namespace meerkwatch */

#endif /* VERIFICADORES_HTTPVERIFICADOR_H_ */
