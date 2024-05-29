use std::{env, fs};

pub mod day1;
pub mod day2;

fn read_file() -> Vec<String> {
    let args: Vec<String> = env::args().collect();
    let file_path = &args[2];
    println!("{}", file_path);

    let contents = fs::read_to_string(file_path).expect("Should have been able to read the file");

    contents.lines().map(|line| line.to_string()).collect()
}
