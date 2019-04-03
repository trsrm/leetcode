#include <cstdio>
#include <string>

void reverseString(char *s, int sSize)
{
    if (sSize <= 0)
    {
        return;
    }
    char temp = *s;
    *s = *(s + sSize - 1);
    *(s + sSize - 1) = temp;
    reverseString(s + 1, sSize - 2);
}

int main()
{
    char s[5] = {'h', 'e', 'l', 'l', 'o'};
    reverseString(s, 5);
    printf("%s", s);
    return 0;
}