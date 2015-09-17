/*
 * CpuVerificador.h
 *
 *  Created on: Sep 16, 2015
 *      Author: ricardovhz
 */

#ifndef CPUVERIFICADOR_H_
#define CPUVERIFICADOR_H_

#include "ThresholdVerificador.h"

namespace meerkwatch {

class CpuVerificador: public ThresholdVerificador {
public:
	CpuVerificador();
	virtual ~CpuVerificador();
};

} /* namespace meerkwatch */

#endif /* CPUVERIFICADOR_H_ */
