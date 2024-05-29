#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1000

int main(int argc, char *argv[]) {
  FILE *textfile;
  char line[MAX_LINE_LENGTH];
  int part2;
  int total = 0;
  int priority, item, comp_size;
  char common_item;

  if (argc == 2) {
    part2 = atoi(argv[1]);
  }

  textfile = fopen("Day3.txt", "r");
  if (textfile == NULL) {
    return 1;
  }

  while (fgets(line, MAX_LINE_LENGTH, textfile)) {
    // printf("%s", line);
    common_item = '\0';
    line[strcspn(line, "\r\n")] = '\0';
    comp_size = floor((strlen(line) / 2.0));
    printf("Size: %d, %d\n", (int)strlen(line), comp_size);

    for (int i = 0; i < comp_size; i++) {
      if (common_item != '\0') {
        break;
      }
      for (int j = 0; j < comp_size; j++) {
        if (line[comp_size + j] == line[i]) {
          common_item = line[i];
          printf("Common item:%c\n", common_item);
          break;
        }
      }
    }
    // now convert the common item to its priority value
    item = (int)common_item;
    priority = 0;
    if (item >= 97 && item <= 122) {
      // is lowercase, subtract 96
      priority = item - 96;
    } else if (item >= 65 && item <= 90) {
      // is uppercase, subtract 38
      priority = item - 38;
    }
    printf("Priority:%d\n", priority);
    // priority gotten, add to running total
    total += priority;
  }
  fclose(textfile);
  printf("Total: %d", total);
  return 0;
}
