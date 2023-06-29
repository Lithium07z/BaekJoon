use std::fmt::Write;
use std::io::stdin;

fn main() {
	let mut t = String::new();
    let mut output = String::new();
    let _ = stdin().read_line(&mut t);
    let number_first: i32 = t.trim().parse::<i32>().expect("Invaild Number Err");

    for _i in 0..number_first {
        let mut a = String::new();
        stdin().read_line(&mut a).unwrap();

        let temp: Vec<&str> = a.split_ascii_whitespace().collect();
        writeln!(output, "{}", temp[0].parse::<i32>().unwrap() + temp[1].parse::<i32>().unwrap()).unwrap();
    }
    print!("{}", output);
}