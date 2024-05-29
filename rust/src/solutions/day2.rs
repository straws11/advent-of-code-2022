use crate::solutions::read_file;

#[derive(PartialEq, Eq)]
enum Move {
    Rock,
    Paper,
    Scissors,
}

struct Piece {
    kind: Move,
    beats: Move,
    value: usize,
}

pub fn solve() {
    let games: Vec<String> = read_file();
    let mut player_score = 0;
    for game in &games {
        // translate into piece objects
        let opp = make_piece(game.chars().next().unwrap());
        let player = make_piece(game.chars().nth(2).unwrap());
        // add the player piece score
        player_score += player.value;
        // add game outcome result
        player_score += get_outcome(opp, player);
    }
    println!("Player Score: {}", player_score);
}

/// Determines outcome of the play, score relative to `player`
fn get_outcome(opp: Piece, player: Piece) -> usize {
    if opp.kind == player.kind {
        // draw
        3
    } else if opp.beats == player.kind {
        // lost
        0
    } else {
        // win
        6
    }
}

fn make_piece(letter: char) -> Piece {
    if matches!(letter, 'A' | 'X') {
        Piece {
            kind: Move::Rock,
            beats: Move::Scissors,
            value: 1,
        }
    } else if matches!(letter, 'B' | 'Y') {
        Piece {
            kind: Move::Paper,
            beats: Move::Rock,
            value: 2,
        }
    } else if matches!(letter, 'C' | 'Z') {
        Piece {
            kind: Move::Scissors,
            beats: Move::Paper,
            value: 3,
        }
    } else {
        panic!("Unexpected letter: {}", letter);
    }
}
