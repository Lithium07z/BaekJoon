use std::io::stdin;
use std::fmt::Write;

fn main() {
    let mut input = String::new();
    let mut output = String::new();
    let _ = stdin().read_line(&mut input);

    let mut numbers = input
        .split_ascii_whitespace()
        .map(|s| s.parse::<usize>().expect("Invaild Number Err"));

    let n = numbers.next().unwrap();

    for i in 1..=n {
        writeln!(output, "{}", i).unwrap();
    }

    print!("{}", output);
}
