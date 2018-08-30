// Learn more about F# at http://fsharp.org

open System
open System.IO

let isVowel x = 
    match x with
    |'a' -> 1
    |'u' -> 1
    |'e' -> 1
    |'i' -> 1
    |'o' -> 1
    | _ -> 0

[<EntryPoint>]
let main argv =
    Console.WriteLine("introduce o arquivo do que contar as vogais:")

    let fileContents = Console.ReadLine() |> File.ReadAllLines

    let partials = fileContents
                   |> Seq.map (fun x -> Seq.map isVowel x |> Seq.sum )
                   |> Seq.iteri (fun i x -> printfn "linea %d numero de vocales %d" i x )

    let result = fileContents 
                |> Seq.collect (id) 
                |> Seq.map Char.ToLower 
                |> Seq.map isVowel 
                |> Seq.sum
    
    printfn "O numero de vogais é %d" result

    0