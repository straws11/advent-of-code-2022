#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1000

int main(int argc, char *argv[]) {
  FILE *textfile;
  char line[MAX_LINE_LENGTH];
  int i = 0;
  int calories[254];
  int part2;

  if (argc == 2) {
    part2 = atoi(argv[1]);
  }

  textfile = fopen("Day1.txt", "r");
  if (textfile == NULL) {
    return 1;
  }

  int total = 0;
  int max = 0;
  int pos = 0;
  while (fgets(line, MAX_LINE_LENGTH, textfile)) {
    // printf("%s", line);

    if (line[0] == '\n') {
      if (total > max) {
        // new max
        max = total;
      }

      if (part2) {
        calories[i] = total;
        i += 1;
      }
      total = 0;

    } else {
      total += atoi(line);
    }
  }

  fclose(textfile);
  if (part2) {
    total = 0;
    for (int a = 0; a < 3; a++) {
      max = 0;
      printf("i is: %d\n", i);
      for (int j = 0; j < i; j++) {
        if (calories[j] > max) {
          max = calories[j];
          pos = j;
        }
      }
      total += max;
      printf("%d\n Pos: %d\n", max, pos);
      calories[pos] = 0;
    }
    printf("Answer: %d", total);
  } else {
    printf("Max: %d", max);
  }
  return 0;
}
