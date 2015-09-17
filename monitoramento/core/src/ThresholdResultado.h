/*
 * ThresholdResultado.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef THRESHOLDRESULTADO_H_
#define THRESHOLDRESULTADO_H_

#include "Resultado.h"

namespace meerkwatch {

class ThresholdResultado: public Resultado {
private:
	double valorObtido;
public:
	ThresholdResultado();
	virtual ~ThresholdResultado();

	double getValorObtido() const {
		return valorObtido;
	}

	void setValorObtido(double valorObtido) {
		this->valorObtido = valorObtido;
	}
};

} /* namespace meerkwatch */

#endif /* THRESHOLDRESULTADO_H_ */
