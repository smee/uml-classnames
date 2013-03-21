# uml-classnames

Parse all .uml-files found recursively in all directories, finds all classes and prints their fully qualified name.

## Installation

    lein uberjar

## Usage

Call with the root directory of your UML2 models.

    $ java -jar target/uml-classnames-0.1.0-standalone.jar [modelDirectory]
or
    $ lein run [modelDirectory]

## License

Copyright © 2013 Steffen Dienst

Distributed under the Eclipse Public License, the same as Clojure.
