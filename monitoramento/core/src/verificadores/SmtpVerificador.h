/*
 * SmtpVerificador.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef VERIFICADORES_SMTPVERIFICADOR_H_
#define VERIFICADORES_SMTPVERIFICADOR_H_

#include "DisponibilidadeVerificador.h"

namespace meerkwatch {

class SmtpVerificador: public DisponibilidadeVerificador {
public:
	SmtpVerificador();
	virtual ~SmtpVerificador();
};

} /* namespace meerkwatch */

#endif /* VERIFICADORES_SMTPVERIFICADOR_H_ */
