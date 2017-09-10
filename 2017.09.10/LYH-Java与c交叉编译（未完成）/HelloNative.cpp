#include "HelloNative.h"
#include "stdio.h"

JNIEXPORT void JNICALL Java_HelloNative_sayHello
{
	prinf("Hello, JNI");
} 
