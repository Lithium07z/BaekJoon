use std::io::{stdin, Read};
use std::fmt::Write;

fn main() {
	let mut input = String::new();
    let mut output = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();
    
    let a = input.next().unwrap().parse::<isize>().unwrap();
    let b = input.next().unwrap().parse::<isize>().unwrap();

    writeln!(output, "{}", a - b).unwrap();
    println!("{output}");
}