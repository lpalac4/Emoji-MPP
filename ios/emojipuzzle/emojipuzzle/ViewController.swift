//
//  ViewController.swift
//  emojipuzzle
//
//  Created by Luis Palacios on 6/18/19.
//  Copyright © 2019 Luis Palacios. All rights reserved.
//

import UIKit
import main

class ViewController: UIViewController {

    var client = PuzzleDomainClient.init()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.font = label.font.withSize(25)
        label.text = "testing"
        view.addSubview(label)
    
    }


}

