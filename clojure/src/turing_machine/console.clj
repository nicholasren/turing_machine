(ns turing_machine.console
	(:use [turing_machine.core])
	(:use [turing_machine.m_config])
	(:use [turing_machine.tape])
	(:use [turing_machine.loader])
	(:gen-class)
)

(defn execute_machine
	[file_path steps]
	(def machine (load_machine file_path))
	(def initial_tape (create_tape))

	(def complete_config_after_execute (execute machine initial_tape steps))
	(print_tape (:tape complete_config_after_execute) steps)
)

(defn -main 
	[& args]
  	(if (empty? args)
		(println "usage: java -jar turing_machine.jar machine_file\n  Execute machine described in machine_file")
		(execute_machine (first args) (new Integer (first (rest args))))
	)
)