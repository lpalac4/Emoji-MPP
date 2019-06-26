//
//  ViewController.swift
//  emojipuzzle
//
//  Created by Luis Palacios on 6/18/19.
//  Copyright © 2019 Luis Palacios. All rights reserved.
//

import UIKit
import main

class ViewController: UIViewController, IEmojiPuzzleView, UITextFieldDelegate {
    
    //MARK: properties
    @IBOutlet weak var emoji: UILabel!
    
    @IBOutlet weak var activeContainer: UIStackView!
    @IBOutlet weak var input: UITextField!
    @IBOutlet weak var feedback: UILabel!
    
    @IBOutlet weak var idleContainer: UIStackView!
    @IBOutlet weak var start: UIButton!
    
    var presenter: PuzzlePresenter!
    var puzzle: EmojiPuzzle!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        activeContainer.isHidden = true
        feedback.text = ""
        
        presenter = PuzzlePresenter.init(mainThread: CoroutineDispatcher() as KotlinCoroutineContext, view: self)
        input.delegate = self
    }

    func textFieldShouldReturn(_ textField: UITextField) -> Bool {   //delegate method
        textField.resignFirstResponder()
        let guess = textField.text
        if(guess == nil || guess == "") { return true }
        
        let solved = puzzle.compareWithCurrentEmoji(text: guess!)
        
        if(solved) {
            feedback.text = "That's right."
        } else {
            feedback.text = "Nope try again. Hint: They're Drake Songs"
        }
        
        return true
    }
    
    @objc
    func tapFunction(sender:UITapGestureRecognizer) {
        puzzle.pickNewEmoji()
        emoji.text = puzzle.currentEmoji?.component1()
    }
    
    @IBAction func buttonClick(_ sender: UIButton) {
        presenter.getPuzzles()
        feedback.text = ""
    }
    
    func onEmojiSuccess(emojiPuzzle: EmojiPuzzle) {
        puzzle = emojiPuzzle
        idleContainer.isHidden = true
        activeContainer.isHidden = false
        emoji.text = puzzle.currentEmoji?.component1()
        
        let refreshEmoji = UITapGestureRecognizer(target: self, action: #selector(ViewController.tapFunction))
        emoji.isUserInteractionEnabled = true
        emoji.addGestureRecognizer(refreshEmoji)
    }
    
    func showError(throwable: KotlinThrowable) {
        
    }
}

public class CoroutineDispatcher: Dispatcher {
    override public func dispatch(context: KotlinCoroutineContext, block: Kotlinx_coroutines_core_nativeRunnable) {
        DispatchQueue.main.async {
            block.run()
        }
    }
}

