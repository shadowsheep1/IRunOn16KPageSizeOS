#include <jni.h>
#include <string>
#include <bits/sysconf.h>

extern "C" JNIEXPORT jint JNICALL
Java_it_versionestabile_irunon16kpagesizeos_MainActivity_getPageSize(
        JNIEnv* env,
        jobject /* this */) {
    return (jint) sysconf(_SC_PAGESIZE);
}