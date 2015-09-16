/*
 * DisponibilidadeResultado.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef DISPONIBILIDADERESULTADO_H_
#define DISPONIBILIDADERESULTADO_H_

#include "Resultado.h"

namespace meerkwatch {

class DisponibilidadeResultado: public Resultado {
private:
	bool disponivel;
public:
	DisponibilidadeResultado();
	virtual ~DisponibilidadeResultado();

	bool isDisponivel() const {
		return disponivel;
	}

	void setDisponivel(bool disponivel) {
		this->disponivel = disponivel;
	}
};

} /* namespace meerkwatch */

#endif /* DISPONIBILIDADERESULTADO_H_ */
