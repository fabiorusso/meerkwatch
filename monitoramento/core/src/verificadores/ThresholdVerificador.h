/*
 * ThresholdVerificador.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef THRESHOLDVERIFICADOR_H_
#define THRESHOLDVERIFICADOR_H_

#include "Verificador.h"

namespace meerkwatch {

class ThresholdVerificador: public Verificador {
public:
	ThresholdVerificador();
	virtual ~ThresholdVerificador();
};

} /* namespace meerkwatch */

#endif /* THRESHOLDVERIFICADOR_H_ */
