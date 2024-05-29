#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1000

int main(int argc, char *argv[]) {
  FILE *textfile;
  char line[MAX_LINE_LENGTH];
  int part2;
  int total = 0;
  int points[3][3] = {{4, 1, 7}, {8, 5, 2}, {3, 9, 6}};
  if (argc == 2) {
    part2 = atoi(argv[1]);
  }

  textfile = fopen("Day2.txt", "r");
  if (textfile == NULL) {
    return 1;
  }

  while (fgets(line, MAX_LINE_LENGTH, textfile)) {
    // printf("%s", line);
    // printf("First %c, Second %c\n", line[0], line[2]);
    int player_mv = (int)line[0] - 65;
    int opp_mv = (int)line[2] - 88;
    // printf("Player %d\n", player_mv);
    // printf("Opp %d\n", opp_mv);
    // printf("Points %d\n", points[opp_mv][player_mv]);

    total += points[opp_mv][player_mv];
  }

  printf("Player's Total Points: %d", total);

  fclose(textfile);
  return 0;
}
