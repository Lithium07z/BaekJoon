use std::io::{stdin, Read};
use std::fmt::Write;

fn main() {
	let mut input = String::new();
    let mut output = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    writeln!(output, "{}", input.next().unwrap().parse::<isize>().unwrap() - input.next().unwrap().parse::<isize>().unwrap()).unwrap();
    println!("{output}");
}