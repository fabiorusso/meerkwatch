/*
 * Verificador.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef VERIFICADOR_H_
#define VERIFICADOR_H_

#include "../Resultado.h"

namespace meerkwatch {

class Verificador {
public:
	Verificador();
	virtual ~Verificador();

	Resultado verificar();
};

} /* namespace meerkwatch */

#endif /* VERIFICADOR_H_ */
