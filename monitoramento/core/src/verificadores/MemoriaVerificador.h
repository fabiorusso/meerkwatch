/*
 * MemoriaVerificador.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef VERIFICADORES_MEMORIAVERIFICADOR_H_
#define VERIFICADORES_MEMORIAVERIFICADOR_H_

#include "ThresholdVerificador.h"

namespace meerkwatch {

class MemoriaVerificador: public ThresholdVerificador {
public:
	MemoriaVerificador();
	virtual ~MemoriaVerificador();
};

} /* namespace meerkwatch */

#endif /* VERIFICADORES_MEMORIAVERIFICADOR_H_ */
