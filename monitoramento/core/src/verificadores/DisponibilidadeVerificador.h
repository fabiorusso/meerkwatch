/*
 * DisponibilidadeVerificador.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef DISPONIBILIDADEVERIFICADOR_H_
#define DISPONIBILIDADEVERIFICADOR_H_

#include "Verificador.h"

namespace meerkwatch {

class DisponibilidadeVerificador: public Verificador {
public:
	DisponibilidadeVerificador();
	virtual ~DisponibilidadeVerificador();
};

} /* namespace meerkwatch */

#endif /* DISPONIBILIDADEVERIFICADOR_H_ */
