import Data.Char

ioMonadTextAsString = (\x -> fmap show $ readFile x)

isVowel 'a' = True
isVowel 'e' = True
isVowel 'i' = True
isVowel 'o' = True
isVowel 'u' = True
isVowel _ = False

mapCharToNumber xs = sum . map (\y -> if isVowel y then 1 else 0) . map toLower  $ xs



main = putStrLn "introduce o nome do ficheiro a contar as vogais:" >> 
        getLine >>= (\y -> ioMonadTextAsString y 
                >>= (\x -> putStrLn . show . mapCharToNumber $ x))
