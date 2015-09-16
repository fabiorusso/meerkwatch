/*
 * ArmazenamentoVerificador.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef VERIFICADORES_ARMAZENAMENTOVERIFICADOR_H_
#define VERIFICADORES_ARMAZENAMENTOVERIFICADOR_H_

#include "ThresholdVerificador.h"

namespace meerkwatch {

class ArmazenamentoVerificador: public ThresholdVerificador {
public:
	ArmazenamentoVerificador();
	virtual ~ArmazenamentoVerificador();
};

} /* namespace meerkwatch */

#endif /* VERIFICADORES_ARMAZENAMENTOVERIFICADOR_H_ */
