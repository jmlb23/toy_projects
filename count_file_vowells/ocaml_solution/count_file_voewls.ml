open Pervasives

type res = | Success of string 
           | Ex
let wrapper name = 
  try Success (input_line name)
  with End_of_file -> Ex

let rec loop i acc =
    match wrapper i with
    | Success r-> loop i ((r) :: acc)
    | Ex -> acc;;

let rec string_to_list str acc = 
  match str with
  | "" -> acc
  | _ -> string_to_list (String.sub str 1 (String.length str - 1) ) (acc @ [String.get str 0]);;

let vowel_to_int ch =
  match Char.lowercase_ascii ch with
  | 'a' -> 1
  | 'e' -> 1
  | 'i' -> 1
  | 'o' -> 1
  | 'u' -> 1
  | _ -> 0;;


let ( >> ) f g = fun x -> g (f x)

let partials xs = List.map (fun x -> string_to_list x []) xs 
                  |> List.map (fun x -> List.map vowel_to_int  x) 
                  |> List.map (fun x -> List.fold_left (+) 0 x)
let total ints = List.fold_left (+) 0 ints
let main () =
  let 
    xs = loop ( (print_endline >> read_line >> open_in) "Introduce un nome de ficheiro a analizar" ) []
  in
    let 
      part = partials xs
      in
      let 
        tot = total part
      in
      part |> List.iteri (fun x y -> Printf.printf "linea %d vogais %d\n" x y);
      Printf.printf "\n\n\no total de vogais é %d\n" tot;;
main ()