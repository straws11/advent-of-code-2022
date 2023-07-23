#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1000

int main(int argc, char *argv[]) {
  FILE *textfile;
  char line[MAX_LINE_LENGTH];
  int part2;

  if (argc == 2) {
    part2 = atoi(argv[1]);
  }

  textfile = fopen("Day1.txt", "r");
  if (textfile == NULL) {
    return 1;
  }

  while (fgets(line, MAX_LINE_LENGTH, textfile)) {
    // printf("%s", line);
  }
  fclose(textfile);
  return 0;
}
