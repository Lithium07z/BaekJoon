use std::io::stdin;

fn main() {
    let mut buffer = String::new();
    stdin().read_line(&mut buffer).unwrap();
    let mut output = String::new();

    let mut token0: Vec<&str> = buffer.split('0').collect();
    let mut token1: Vec<&str> = buffer.split('1').collect();

    token0 = token0.iter()
    .filter(|&&s| s.trim() != "")
    .cloned()
    .collect();

    token1 = token1.iter()
    .filter(|&&s| s.trim() != "")
    .cloned()
    .collect();

    if token0.len() > token1.len() {
        println!("{}", token1.len());
    } else {
        println!("{}", token0.len());
    };
}
