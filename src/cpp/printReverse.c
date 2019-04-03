#include <stdio.h>

void printReverse(const char *str) {
  if (!*str)
    return;
  printReverse(str + 1);
  putchar(*str);
}

int main () {
    printReverse("12345");
}

