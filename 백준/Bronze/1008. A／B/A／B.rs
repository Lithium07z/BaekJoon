use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    let mut output = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let a = input.next().unwrap().parse::<f64>().unwrap();
    let b = input.next().unwrap().parse::<f64>().unwrap();

    writeln!(output, "{}", a / b).unwrap();
    println!("{output}");
}