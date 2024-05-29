use crate::solutions::read_file;

pub fn solve() {
    println!("Solution for day1!");

    let inventory = read_file();
    //println!("{:?}", args);

    let mut total: usize = 0;
    let mut invs: Vec<usize> = Vec::new();

    for line in &inventory {
        if line.is_empty() {
            //max = if total < max { max } else { total };
            invs.push(total);
            total = 0;
        } else {
            total += line.parse::<usize>().unwrap();
        }
    }

    invs.sort_by(|a, b| b.cmp(a));
    println!("Part 1: {}", invs[0]);
    println!("Part 2: {}", invs[0..3].iter().sum::<usize>());
}
