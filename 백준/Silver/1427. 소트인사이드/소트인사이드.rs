use std::io::stdin;
use std::fmt::Write;

fn main() {
    let mut buffer = String::new();
    stdin().read_line(&mut buffer).unwrap();
    let input = buffer.trim_end();
    let mut output = String::new();

    let mut vec: Vec<char> = Vec::new(); 
  
    for ch in input.chars() {
        vec.push(ch);
    }

    vec.sort();
    vec.reverse();

    for i in vec {
        write!(output, "{i}").unwrap(); 
    }

    println!("{output}");
}
