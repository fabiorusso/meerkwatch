/*
 * Resultado.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef RESULTADO_H_
#define RESULTADO_H_

namespace meerkwatch {

enum TipoParametro {
	DISPONIBILIDADE=1, THESHOLD=2
};

class Resultado {

private:
	TipoParametro tipoParametro;

public:
	Resultado();
	virtual ~Resultado();

	TipoParametro getTipoParametro() const {
		return tipoParametro;
	}

	void setTipoParametro(TipoParametro tipoParametro) {
		this->tipoParametro = tipoParametro;
	}
};

} /* namespace meerkwatch */

#endif /* RESULTADO_H_ */
