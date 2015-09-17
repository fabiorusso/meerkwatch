################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/verificadores/ArmazenamentoVerificador.cpp \
../src/verificadores/CpuVerificador.cpp \
../src/verificadores/DisponibilidadeVerificador.cpp \
../src/verificadores/HttpVerificador.cpp \
../src/verificadores/MemoriaVerificador.cpp \
../src/verificadores/SmtpVerificador.cpp \
../src/verificadores/ThresholdVerificador.cpp \
../src/verificadores/Verificador.cpp 

OBJS += \
./src/verificadores/ArmazenamentoVerificador.o \
./src/verificadores/CpuVerificador.o \
./src/verificadores/DisponibilidadeVerificador.o \
./src/verificadores/HttpVerificador.o \
./src/verificadores/MemoriaVerificador.o \
./src/verificadores/SmtpVerificador.o \
./src/verificadores/ThresholdVerificador.o \
./src/verificadores/Verificador.o 

CPP_DEPS += \
./src/verificadores/ArmazenamentoVerificador.d \
./src/verificadores/CpuVerificador.d \
./src/verificadores/DisponibilidadeVerificador.d \
./src/verificadores/HttpVerificador.d \
./src/verificadores/MemoriaVerificador.d \
./src/verificadores/SmtpVerificador.d \
./src/verificadores/ThresholdVerificador.d \
./src/verificadores/Verificador.d 


# Each subdirectory must supply rules for building sources it contributes
src/verificadores/%.o: ../src/verificadores/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


