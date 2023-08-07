use std::io::{stdin, Read};
use std::fmt::Write;

fn main() {
	let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);
    let mut output = String::new();
    
    let a = input.next().unwrap();
    let b = input.next().unwrap();

    writeln!(output, "{}", a * b).unwrap();
    println!("{}", output);
}