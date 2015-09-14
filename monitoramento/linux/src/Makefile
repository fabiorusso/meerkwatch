source=Application.cpp Application.h main.cpp
objects = Application.o main.o
target = meerkd

all : $(target)

$(target) : $(objects)
	g++ -o $(target) $(objects) 
	
main.o : main.cpp
	g++ -c main.cpp

Application.o : Application.cpp Application.h
	g++ -c Application.cpp

clean :
	rm $(objects) $(target)
 